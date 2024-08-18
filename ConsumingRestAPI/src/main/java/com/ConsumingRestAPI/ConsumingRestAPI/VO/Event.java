package com.ConsumingRestAPI.ConsumingRestAPI.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("event-name")
    private String eventName;

    @JsonProperty("event-task")
    private String eventTask;

    @JsonProperty("start-date")
    private Date startDate;

    @JsonProperty("dead-line")
    private Date deadLine;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("id")
    private String id;
}
