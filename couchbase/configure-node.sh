#!/bin/bash

set -m

set -e

/entrypoint.sh couchbase-server &

# Check if couchbase server is up
check_db() {
  curl --silent http://127.0.0.1:8091/pools > /dev/null
  echo $?
}

# Variable used in echo
i=1
# Echo with
log() {
  echo "[$i] [$(date +"%T")] $@"
  i=`expr $i + 1`
}

# Wait until it's ready
until [[ $(check_db) = 0 ]]; do
  >&2 log "Waiting for Couchbase Server to be available ..."
  sleep 1
done

# Setup index and memory quota
log "$(date +"%T") Init cluster ........."
  couchbase-cli cluster-init -c 127.0.0.1 --cluster-username Administrator --cluster-password password \
  --cluster-name myCluster --cluster-ramsize 1024 --cluster-index-ramsize 256 --services data,index,query,fts \
  --index-storage-setting default || log "$(date +"%T") Init cluster failed probably already exists"

# Create the buckets
log "$(date +"%T") Create buckets ........."
couchbase-cli bucket-create -c 127.0.0.1 --username Administrator --password password --bucket-type couchbase --bucket-ramsize 250 --bucket test \
|| log "$(date +"%T") Create buckets failed for test bucket probably already exists"


# Create user
log "$(date +"%T") Create users ........."
couchbase-cli user-manage -c 127.0.0.1:8091 -u Administrator -p password --set --rbac-username test --rbac-password couchbase \
 --rbac-name "sysadmin" --roles admin --auth-domain local \
|| log "$(date +"%T") Create users failed for test user probably already exists"

# Need to wait until query service is ready to process N1QL queries
log "$(date +"%T") Waiting ........."
sleep 20

fg 1
