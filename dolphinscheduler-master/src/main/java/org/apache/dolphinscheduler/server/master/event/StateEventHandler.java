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

package org.apache.dolphinscheduler.server.master.event;

import org.apache.dolphinscheduler.common.enums.StateEventType;
import org.apache.dolphinscheduler.server.master.runner.WorkflowExecuteRunnable;

public interface StateEventHandler {

    /**
     * Handle a event, if handle success will reture true, else return false
     *
     * @param stateEvent given state event.
     * @throws StateEventHandleException this exception means it can be recovered.
     * @throws StateEventHandleError     this exception means it cannot be recovered, so the event need to drop.
     * @throws StateEventHandleException this means it can be recovered.
     */
    boolean handleStateEvent(WorkflowExecuteRunnable workflowExecuteRunnable,
                             StateEvent stateEvent) throws StateEventHandleException, StateEventHandleError, StateEventHandleFailure;

    StateEventType getEventType();
}
