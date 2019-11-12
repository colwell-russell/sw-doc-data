package com.colwell.coding.swdocdata.repository;

import com.colwell.coding.swdocdata.entity.Project;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

import java.util.List;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "project")
public interface ProjectRepository extends CouchbasePagingAndSortingRepository<Project, String> {

}
