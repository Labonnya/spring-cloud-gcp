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

package com.google.cloud.orchestration.airflow.service.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient;
import com.google.cloud.orchestration.airflow.service.v1.EnvironmentsSettings;
import com.google.cloud.spring.autoconfigure.core.GcpContextAutoConfiguration;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.core.Retry;
import com.google.cloud.spring.core.util.RetryUtil;
import java.io.IOException;
import java.util.Collections;
import javax.annotation.Generated;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link EnvironmentsClient}.
 *
 * <p>Provides auto-configuration for Spring Boot
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default transport provider is used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@AutoConfiguration
@AutoConfigureAfter(GcpContextAutoConfiguration.class)
@ConditionalOnClass(EnvironmentsClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.orchestration.airflow.service.v1.environments.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(EnvironmentsSpringProperties.class)
public class EnvironmentsSpringAutoConfiguration {
  private final EnvironmentsSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(EnvironmentsSpringAutoConfiguration.class);

  protected EnvironmentsSpringAutoConfiguration(
      EnvironmentsSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from Environments-specific configuration");
      }
      this.credentialsProvider =
          ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    } else {
      this.credentialsProvider = credentialsProvider;
    }
  }

  /**
   * Provides a default transport channel provider bean, corresponding to the client library's
   * default transport channel provider. If the library supports both GRPC and REST transport, and
   * the useRest property is configured, the HTTP/JSON transport provider will be used instead of
   * GRPC.
   *
   * @return a default transport channel provider.
   */
  @Bean
  @ConditionalOnMissingBean(name = "defaultEnvironmentsTransportChannelProvider")
  public TransportChannelProvider defaultEnvironmentsTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return EnvironmentsSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return EnvironmentsSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a EnvironmentsSettings bean configured to use a DefaultCredentialsProvider and the
   * client library's default transport channel provider
   * (defaultEnvironmentsTransportChannelProvider()). It also configures the quota project ID and
   * executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in EnvironmentsSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link EnvironmentsSettings} bean configured with {@link TransportChannelProvider}
   *     bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public EnvironmentsSettings environmentsSettings(
      @Qualifier("defaultEnvironmentsTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    EnvironmentsSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = EnvironmentsSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = EnvironmentsSettings.newBuilder();
    }
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setHeaderProvider(this.userAgentHeaderProvider());
    if (this.clientProperties.getQuotaProjectId() != null) {
      clientSettingsBuilder.setQuotaProjectId(this.clientProperties.getQuotaProjectId());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Quota project id set to "
                + this.clientProperties.getQuotaProjectId()
                + ", this overrides project id from credentials.");
      }
    }
    if (this.clientProperties.getExecutorThreadCount() != null) {
      ExecutorProvider executorProvider =
          EnvironmentsSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings getEnvironmentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getEnvironmentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getEnvironmentSettings().setRetrySettings(getEnvironmentRetrySettings);

      RetrySettings listEnvironmentsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listEnvironmentsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listEnvironmentsSettings()
          .setRetrySettings(listEnvironmentsRetrySettings);

      RetrySettings executeAirflowCommandRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.executeAirflowCommandSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .executeAirflowCommandSettings()
          .setRetrySettings(executeAirflowCommandRetrySettings);

      RetrySettings stopAirflowCommandRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.stopAirflowCommandSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .stopAirflowCommandSettings()
          .setRetrySettings(stopAirflowCommandRetrySettings);

      RetrySettings pollAirflowCommandRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.pollAirflowCommandSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .pollAirflowCommandSettings()
          .setRetrySettings(pollAirflowCommandRetrySettings);

      RetrySettings fetchDatabasePropertiesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.fetchDatabasePropertiesSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .fetchDatabasePropertiesSettings()
          .setRetrySettings(fetchDatabasePropertiesRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry getEnvironmentRetry = clientProperties.getGetEnvironmentRetry();
    if (getEnvironmentRetry != null) {
      RetrySettings getEnvironmentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getEnvironmentSettings().getRetrySettings(),
              getEnvironmentRetry);
      clientSettingsBuilder.getEnvironmentSettings().setRetrySettings(getEnvironmentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getEnvironment from properties.");
      }
    }
    Retry listEnvironmentsRetry = clientProperties.getListEnvironmentsRetry();
    if (listEnvironmentsRetry != null) {
      RetrySettings listEnvironmentsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listEnvironmentsSettings().getRetrySettings(),
              listEnvironmentsRetry);
      clientSettingsBuilder
          .listEnvironmentsSettings()
          .setRetrySettings(listEnvironmentsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listEnvironments from properties.");
      }
    }
    Retry executeAirflowCommandRetry = clientProperties.getExecuteAirflowCommandRetry();
    if (executeAirflowCommandRetry != null) {
      RetrySettings executeAirflowCommandRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.executeAirflowCommandSettings().getRetrySettings(),
              executeAirflowCommandRetry);
      clientSettingsBuilder
          .executeAirflowCommandSettings()
          .setRetrySettings(executeAirflowCommandRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for executeAirflowCommand from properties.");
      }
    }
    Retry stopAirflowCommandRetry = clientProperties.getStopAirflowCommandRetry();
    if (stopAirflowCommandRetry != null) {
      RetrySettings stopAirflowCommandRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.stopAirflowCommandSettings().getRetrySettings(),
              stopAirflowCommandRetry);
      clientSettingsBuilder
          .stopAirflowCommandSettings()
          .setRetrySettings(stopAirflowCommandRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for stopAirflowCommand from properties.");
      }
    }
    Retry pollAirflowCommandRetry = clientProperties.getPollAirflowCommandRetry();
    if (pollAirflowCommandRetry != null) {
      RetrySettings pollAirflowCommandRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.pollAirflowCommandSettings().getRetrySettings(),
              pollAirflowCommandRetry);
      clientSettingsBuilder
          .pollAirflowCommandSettings()
          .setRetrySettings(pollAirflowCommandRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for pollAirflowCommand from properties.");
      }
    }
    Retry fetchDatabasePropertiesRetry = clientProperties.getFetchDatabasePropertiesRetry();
    if (fetchDatabasePropertiesRetry != null) {
      RetrySettings fetchDatabasePropertiesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.fetchDatabasePropertiesSettings().getRetrySettings(),
              fetchDatabasePropertiesRetry);
      clientSettingsBuilder
          .fetchDatabasePropertiesSettings()
          .setRetrySettings(fetchDatabasePropertiesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for fetchDatabaseProperties from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a EnvironmentsClient bean configured with EnvironmentsSettings.
   *
   * @param environmentsSettings settings to configure an instance of client bean.
   * @return a {@link EnvironmentsClient} bean configured with {@link EnvironmentsSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public EnvironmentsClient environmentsClient(EnvironmentsSettings environmentsSettings)
      throws IOException {
    return EnvironmentsClient.create(environmentsSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-environments";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
