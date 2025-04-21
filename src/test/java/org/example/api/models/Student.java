package org.example.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Student {
    private String name;
    private int grade;

    @SerializedName("_id")
    @Expose(serialize = false, deserialize = true)
    private String id;
}
