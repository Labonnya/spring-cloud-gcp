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

package com.google.cloud.billing.budgets.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.billing.budgets.v1.BudgetServiceClient;
import com.google.cloud.billing.budgets.v1.BudgetServiceSettings;
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
 * Auto-configuration for {@link BudgetServiceClient}.
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
@ConditionalOnClass(BudgetServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.billing.budgets.v1.budget-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(BudgetServiceSpringProperties.class)
public class BudgetServiceSpringAutoConfiguration {
  private final BudgetServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(BudgetServiceSpringAutoConfiguration.class);

  protected BudgetServiceSpringAutoConfiguration(
      BudgetServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from BudgetService-specific configuration");
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
  @ConditionalOnMissingBean(name = "defaultBudgetServiceTransportChannelProvider")
  public TransportChannelProvider defaultBudgetServiceTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return BudgetServiceSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return BudgetServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a BudgetServiceSettings bean configured to use a DefaultCredentialsProvider and the
   * client library's default transport channel provider
   * (defaultBudgetServiceTransportChannelProvider()). It also configures the quota project ID and
   * executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in BudgetServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link BudgetServiceSettings} bean configured with {@link TransportChannelProvider}
   *     bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public BudgetServiceSettings budgetServiceSettings(
      @Qualifier("defaultBudgetServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    BudgetServiceSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = BudgetServiceSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = BudgetServiceSettings.newBuilder();
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
          BudgetServiceSettings.defaultExecutorProviderBuilder()
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
      RetrySettings createBudgetRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createBudgetSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createBudgetSettings().setRetrySettings(createBudgetRetrySettings);

      RetrySettings updateBudgetRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateBudgetSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateBudgetSettings().setRetrySettings(updateBudgetRetrySettings);

      RetrySettings getBudgetRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getBudgetSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getBudgetSettings().setRetrySettings(getBudgetRetrySettings);

      RetrySettings listBudgetsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listBudgetsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listBudgetsSettings().setRetrySettings(listBudgetsRetrySettings);

      RetrySettings deleteBudgetRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteBudgetSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteBudgetSettings().setRetrySettings(deleteBudgetRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry createBudgetRetry = clientProperties.getCreateBudgetRetry();
    if (createBudgetRetry != null) {
      RetrySettings createBudgetRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createBudgetSettings().getRetrySettings(), createBudgetRetry);
      clientSettingsBuilder.createBudgetSettings().setRetrySettings(createBudgetRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createBudget from properties.");
      }
    }
    Retry updateBudgetRetry = clientProperties.getUpdateBudgetRetry();
    if (updateBudgetRetry != null) {
      RetrySettings updateBudgetRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateBudgetSettings().getRetrySettings(), updateBudgetRetry);
      clientSettingsBuilder.updateBudgetSettings().setRetrySettings(updateBudgetRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateBudget from properties.");
      }
    }
    Retry getBudgetRetry = clientProperties.getGetBudgetRetry();
    if (getBudgetRetry != null) {
      RetrySettings getBudgetRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getBudgetSettings().getRetrySettings(), getBudgetRetry);
      clientSettingsBuilder.getBudgetSettings().setRetrySettings(getBudgetRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getBudget from properties.");
      }
    }
    Retry listBudgetsRetry = clientProperties.getListBudgetsRetry();
    if (listBudgetsRetry != null) {
      RetrySettings listBudgetsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listBudgetsSettings().getRetrySettings(), listBudgetsRetry);
      clientSettingsBuilder.listBudgetsSettings().setRetrySettings(listBudgetsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listBudgets from properties.");
      }
    }
    Retry deleteBudgetRetry = clientProperties.getDeleteBudgetRetry();
    if (deleteBudgetRetry != null) {
      RetrySettings deleteBudgetRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteBudgetSettings().getRetrySettings(), deleteBudgetRetry);
      clientSettingsBuilder.deleteBudgetSettings().setRetrySettings(deleteBudgetRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteBudget from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a BudgetServiceClient bean configured with BudgetServiceSettings.
   *
   * @param budgetServiceSettings settings to configure an instance of client bean.
   * @return a {@link BudgetServiceClient} bean configured with {@link BudgetServiceSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public BudgetServiceClient budgetServiceClient(BudgetServiceSettings budgetServiceSettings)
      throws IOException {
    return BudgetServiceClient.create(budgetServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-budget-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
