/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.servicedirectory.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for RegistrationService client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.servicedirectory.v1.registration-service")
public class RegistrationServiceSpringProperties implements CredentialsSupplier {
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
   * Allow override of retry settings at method-level for createNamespace. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createNamespaceRetry;
  /**
   * Allow override of retry settings at method-level for listNamespaces. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listNamespacesRetry;
  /**
   * Allow override of retry settings at method-level for getNamespace. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getNamespaceRetry;
  /**
   * Allow override of retry settings at method-level for updateNamespace. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateNamespaceRetry;
  /**
   * Allow override of retry settings at method-level for deleteNamespace. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteNamespaceRetry;
  /**
   * Allow override of retry settings at method-level for createService. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createServiceRetry;
  /**
   * Allow override of retry settings at method-level for listServices. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listServicesRetry;
  /**
   * Allow override of retry settings at method-level for getService. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getServiceRetry;
  /**
   * Allow override of retry settings at method-level for updateService. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateServiceRetry;
  /**
   * Allow override of retry settings at method-level for deleteService. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteServiceRetry;
  /**
   * Allow override of retry settings at method-level for createEndpoint. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createEndpointRetry;
  /**
   * Allow override of retry settings at method-level for listEndpoints. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listEndpointsRetry;
  /**
   * Allow override of retry settings at method-level for getEndpoint. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getEndpointRetry;
  /**
   * Allow override of retry settings at method-level for updateEndpoint. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateEndpointRetry;
  /**
   * Allow override of retry settings at method-level for deleteEndpoint. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteEndpointRetry;
  /**
   * Allow override of retry settings at method-level for getIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for setIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry setIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for testIamPermissions. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry testIamPermissionsRetry;
  /**
   * Allow override of retry settings at method-level for listLocations. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listLocationsRetry;
  /**
   * Allow override of retry settings at method-level for getLocation. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getLocationRetry;

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

  public Retry getCreateNamespaceRetry() {
    return this.createNamespaceRetry;
  }

  public void setCreateNamespaceRetry(Retry createNamespaceRetry) {
    this.createNamespaceRetry = createNamespaceRetry;
  }

  public Retry getListNamespacesRetry() {
    return this.listNamespacesRetry;
  }

  public void setListNamespacesRetry(Retry listNamespacesRetry) {
    this.listNamespacesRetry = listNamespacesRetry;
  }

  public Retry getGetNamespaceRetry() {
    return this.getNamespaceRetry;
  }

  public void setGetNamespaceRetry(Retry getNamespaceRetry) {
    this.getNamespaceRetry = getNamespaceRetry;
  }

  public Retry getUpdateNamespaceRetry() {
    return this.updateNamespaceRetry;
  }

  public void setUpdateNamespaceRetry(Retry updateNamespaceRetry) {
    this.updateNamespaceRetry = updateNamespaceRetry;
  }

  public Retry getDeleteNamespaceRetry() {
    return this.deleteNamespaceRetry;
  }

  public void setDeleteNamespaceRetry(Retry deleteNamespaceRetry) {
    this.deleteNamespaceRetry = deleteNamespaceRetry;
  }

  public Retry getCreateServiceRetry() {
    return this.createServiceRetry;
  }

  public void setCreateServiceRetry(Retry createServiceRetry) {
    this.createServiceRetry = createServiceRetry;
  }

  public Retry getListServicesRetry() {
    return this.listServicesRetry;
  }

  public void setListServicesRetry(Retry listServicesRetry) {
    this.listServicesRetry = listServicesRetry;
  }

  public Retry getGetServiceRetry() {
    return this.getServiceRetry;
  }

  public void setGetServiceRetry(Retry getServiceRetry) {
    this.getServiceRetry = getServiceRetry;
  }

  public Retry getUpdateServiceRetry() {
    return this.updateServiceRetry;
  }

  public void setUpdateServiceRetry(Retry updateServiceRetry) {
    this.updateServiceRetry = updateServiceRetry;
  }

  public Retry getDeleteServiceRetry() {
    return this.deleteServiceRetry;
  }

  public void setDeleteServiceRetry(Retry deleteServiceRetry) {
    this.deleteServiceRetry = deleteServiceRetry;
  }

  public Retry getCreateEndpointRetry() {
    return this.createEndpointRetry;
  }

  public void setCreateEndpointRetry(Retry createEndpointRetry) {
    this.createEndpointRetry = createEndpointRetry;
  }

  public Retry getListEndpointsRetry() {
    return this.listEndpointsRetry;
  }

  public void setListEndpointsRetry(Retry listEndpointsRetry) {
    this.listEndpointsRetry = listEndpointsRetry;
  }

  public Retry getGetEndpointRetry() {
    return this.getEndpointRetry;
  }

  public void setGetEndpointRetry(Retry getEndpointRetry) {
    this.getEndpointRetry = getEndpointRetry;
  }

  public Retry getUpdateEndpointRetry() {
    return this.updateEndpointRetry;
  }

  public void setUpdateEndpointRetry(Retry updateEndpointRetry) {
    this.updateEndpointRetry = updateEndpointRetry;
  }

  public Retry getDeleteEndpointRetry() {
    return this.deleteEndpointRetry;
  }

  public void setDeleteEndpointRetry(Retry deleteEndpointRetry) {
    this.deleteEndpointRetry = deleteEndpointRetry;
  }

  public Retry getGetIamPolicyRetry() {
    return this.getIamPolicyRetry;
  }

  public void setGetIamPolicyRetry(Retry getIamPolicyRetry) {
    this.getIamPolicyRetry = getIamPolicyRetry;
  }

  public Retry getSetIamPolicyRetry() {
    return this.setIamPolicyRetry;
  }

  public void setSetIamPolicyRetry(Retry setIamPolicyRetry) {
    this.setIamPolicyRetry = setIamPolicyRetry;
  }

  public Retry getTestIamPermissionsRetry() {
    return this.testIamPermissionsRetry;
  }

  public void setTestIamPermissionsRetry(Retry testIamPermissionsRetry) {
    this.testIamPermissionsRetry = testIamPermissionsRetry;
  }

  public Retry getListLocationsRetry() {
    return this.listLocationsRetry;
  }

  public void setListLocationsRetry(Retry listLocationsRetry) {
    this.listLocationsRetry = listLocationsRetry;
  }

  public Retry getGetLocationRetry() {
    return this.getLocationRetry;
  }

  public void setGetLocationRetry(Retry getLocationRetry) {
    this.getLocationRetry = getLocationRetry;
  }
}
