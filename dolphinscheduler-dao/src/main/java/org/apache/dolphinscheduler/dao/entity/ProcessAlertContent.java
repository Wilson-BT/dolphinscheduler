/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.dao.entity;

import org.apache.dolphinscheduler.common.enums.AlertEvent;
import org.apache.dolphinscheduler.common.enums.AlertWarnLevel;
import org.apache.dolphinscheduler.common.enums.CommandType;
import org.apache.dolphinscheduler.common.enums.Flag;
import org.apache.dolphinscheduler.plugin.task.api.enums.ExecutionStatus;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ProcessAlertContent implements Serializable {

    @JsonProperty("项目ID")
    private Integer projectId;
    @JsonProperty("项目编码")
    private Long projectCode;
    @JsonProperty("项目名称")
    private String projectName;
    @JsonProperty("流程创建人")
    private String owner;
    @JsonProperty("流程ID")
    private Integer processId;
    @JsonProperty("流程定义编码")
    private Long processDefinitionCode;
    @JsonProperty("流程名称")
    private String processName;
    @JsonProperty("流程类型")
    private CommandType processType;
    @JsonProperty("流程状态")
    private ExecutionStatus processState;
    @JsonProperty("是否重启过")
    private Flag recovery;
    @JsonProperty("运行次数")
    private Integer runTimes;
    @JsonProperty("流程开始时间")
    private Date processStartTime;
    @JsonProperty("流程结束时间")
    private Date processEndTime;
    @JsonProperty("流程Host")
    private String processHost;
    @JsonProperty("任务编码")
    private Long taskCode;
    @JsonProperty("任务名称")
    private String taskName;
    @JsonProperty("告警事件")
    private AlertEvent event;
    @JsonProperty("告警级别")
    private AlertWarnLevel warnLevel;
    @JsonProperty("任务类型")
    private String taskType;
    @JsonProperty("重试次数")
    private Integer retryTimes;
    @JsonProperty("任务状态")
    private ExecutionStatus taskState;
    @JsonProperty("任务开始时间")
    private Date taskStartTime;
    @JsonProperty("任务结束时间")
    private Date taskEndTime;
    @JsonProperty("任务运行Host")
    private String taskHost;
    @JsonProperty("日志路径")
    private String logPath;

    private ProcessAlertContent(Builder builder) {
        this.projectId = builder.projectId;
        this.projectCode = builder.projectCode;
        this.projectName = builder.projectName;
        this.owner = builder.owner;
        this.processId = builder.processId;
        this.processDefinitionCode = builder.processDefinitionCode;
        this.processName = builder.processName;
        this.processType = builder.processType;
        this.recovery = builder.recovery;
        this.processState = builder.processState;
        this.runTimes = builder.runTimes;
        this.processStartTime = builder.processStartTime;
        this.processEndTime = builder.processEndTime;
        this.processHost = builder.processHost;
        this.taskCode = builder.taskCode;
        this.taskName = builder.taskName;
        this.event = builder.event;
        this.warnLevel = builder.warnLevel;
        this.taskType = builder.taskType;
        this.taskState = builder.taskState;
        this.taskStartTime = builder.taskStartTime;
        this.taskEndTime = builder.taskEndTime;
        this.taskHost = builder.taskHost;
        this.logPath = builder.logPath;
        this.retryTimes = builder.retryTimes;

    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Integer projectId;
        private Long projectCode;
        private String projectName;
        private String owner;
        private Integer processId;
        private Long processDefinitionCode;
        private String processName;
        private CommandType processType;
        private Flag recovery;
        private ExecutionStatus processState;
        private Integer runTimes;
        private Date processStartTime;
        private Date processEndTime;
        private String processHost;
        private Long taskCode;
        private String taskName;
        private AlertEvent event;
        private AlertWarnLevel warnLevel;
        private String taskType;
        private Integer retryTimes;
        private ExecutionStatus taskState;
        private Date taskStartTime;
        private Date taskEndTime;
        private String taskHost;
        private String logPath;

        public Builder projectId(Integer projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder projectCode(Long projectCode) {
            this.projectCode = projectCode;
            return this;
        }

        public Builder projectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public Builder owner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder processId(Integer processId) {
            this.processId = processId;
            return this;
        }

        public Builder processDefinitionCode(Long processDefinitionCode) {
            this.processDefinitionCode = processDefinitionCode;
            return this;
        }

        public Builder processName(String processName) {
            this.processName = processName;
            return this;
        }

        public Builder processType(CommandType processType) {
            this.processType = processType;
            return this;
        }

        public Builder recovery(Flag recovery) {
            this.recovery = recovery;
            return this;
        }

        public Builder processState(ExecutionStatus processState) {
            this.processState = processState;
            return this;
        }

        public Builder runTimes(Integer runTimes) {
            this.runTimes = runTimes;
            return this;
        }

        public Builder processStartTime(Date processStartTime) {
            this.processStartTime = processStartTime;
            return this;
        }

        public Builder processEndTime(Date processEndTime) {
            this.processEndTime = processEndTime;
            return this;
        }

        public Builder processHost(String processHost) {
            this.processHost = processHost;
            return this;
        }

        public Builder taskCode(Long taskCode) {
            this.taskCode = taskCode;
            return this;
        }

        public Builder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        public Builder event(AlertEvent event) {
            this.event = event;
            return this;
        }

        public Builder warningLevel(AlertWarnLevel warnLevel) {
            this.warnLevel = warnLevel;
            return this;
        }

        public Builder taskType(String taskType) {
            this.taskType = taskType;
            return this;
        }

        public Builder retryTimes(Integer retryTimes) {
            this.retryTimes = retryTimes;
            return this;
        }

        public Builder taskState(ExecutionStatus taskState) {
            this.taskState = taskState;
            return this;
        }

        public Builder taskStartTime(Date taskStartTime) {
            this.taskStartTime = taskStartTime;
            return this;
        }

        public Builder taskEndTime(Date taskEndTime) {
            this.taskEndTime = taskEndTime;
            return this;
        }

        public Builder taskHost(String taskHost) {
            this.taskHost = taskHost;
            return this;
        }

        public Builder logPath(String logPath) {
            this.logPath = logPath;
            return this;
        }

        public ProcessAlertContent build() {
            return new ProcessAlertContent(this);
        }
    }
}
