/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.dataproc.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for WorkflowTemplateService client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.dataproc.v1.workflow-template-service")
public class WorkflowTemplateServiceSpringProperties implements CredentialsSupplier {
  /** OAuth2 credentials to authenticate and authorize calls to Google Cloud Client Libraries. */
  @NestedConfigurationProperty
  private final Credentials credentials =
      new Credentials("https://www.googleapis.com/auth/cloud-platform");
  /** Quota project to use for billing. */
  private String quotaProjectId;
  /** Number of threads used for executors. */
  private Integer executorThreadCount;
  /** Allow override of default transport channel provider to use REST instead of gRPC. */
  private boolean useRest = false;
  /** Allow override of retry settings at service level, applying to all of its RPC methods. */
  @NestedConfigurationProperty private Retry retry;
  /**
   * Allow override of retry settings at method-level for createWorkflowTemplate. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createWorkflowTemplateRetry;
  /**
   * Allow override of retry settings at method-level for getWorkflowTemplate. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getWorkflowTemplateRetry;
  /**
   * Allow override of retry settings at method-level for updateWorkflowTemplate. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateWorkflowTemplateRetry;
  /**
   * Allow override of retry settings at method-level for listWorkflowTemplates. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listWorkflowTemplatesRetry;
  /**
   * Allow override of retry settings at method-level for deleteWorkflowTemplate. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteWorkflowTemplateRetry;

  @Override
  public Credentials getCredentials() {
    return this.credentials;
  }

  public String getQuotaProjectId() {
    return this.quotaProjectId;
  }

  public void setQuotaProjectId(String quotaProjectId) {
    this.quotaProjectId = quotaProjectId;
  }

  public boolean getUseRest() {
    return this.useRest;
  }

  public void setUseRest(boolean useRest) {
    this.useRest = useRest;
  }

  public Integer getExecutorThreadCount() {
    return this.executorThreadCount;
  }

  public void setExecutorThreadCount(Integer executorThreadCount) {
    this.executorThreadCount = executorThreadCount;
  }

  public Retry getRetry() {
    return this.retry;
  }

  public void setRetry(Retry retry) {
    this.retry = retry;
  }

  public Retry getCreateWorkflowTemplateRetry() {
    return this.createWorkflowTemplateRetry;
  }

  public void setCreateWorkflowTemplateRetry(Retry createWorkflowTemplateRetry) {
    this.createWorkflowTemplateRetry = createWorkflowTemplateRetry;
  }

  public Retry getGetWorkflowTemplateRetry() {
    return this.getWorkflowTemplateRetry;
  }

  public void setGetWorkflowTemplateRetry(Retry getWorkflowTemplateRetry) {
    this.getWorkflowTemplateRetry = getWorkflowTemplateRetry;
  }

  public Retry getUpdateWorkflowTemplateRetry() {
    return this.updateWorkflowTemplateRetry;
  }

  public void setUpdateWorkflowTemplateRetry(Retry updateWorkflowTemplateRetry) {
    this.updateWorkflowTemplateRetry = updateWorkflowTemplateRetry;
  }

  public Retry getListWorkflowTemplatesRetry() {
    return this.listWorkflowTemplatesRetry;
  }

  public void setListWorkflowTemplatesRetry(Retry listWorkflowTemplatesRetry) {
    this.listWorkflowTemplatesRetry = listWorkflowTemplatesRetry;
  }

  public Retry getDeleteWorkflowTemplateRetry() {
    return this.deleteWorkflowTemplateRetry;
  }

  public void setDeleteWorkflowTemplateRetry(Retry deleteWorkflowTemplateRetry) {
    this.deleteWorkflowTemplateRetry = deleteWorkflowTemplateRetry;
  }
}