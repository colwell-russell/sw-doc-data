package com.colwell.coding.swdocdata.entity;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Project {

    @NotNull
    @Id
    private String id;

    @NotNull
    @Field
    private String projectName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
