package it.auties.whatsapp4j.protobuf.message;

import com.fasterxml.jackson.annotation.*;
import java.util.*;

import it.auties.whatsapp4j.api.WhatsappAPI;
import it.auties.whatsapp4j.protobuf.model.HSMLocalizableParameter;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * A model class that represents a WhatsappMessage that contains a highly structured message inside.
 * Not much is known about this type of message as no one has encountered it.
 * This class is only a model, this means that changing its values will have no real effect on WhatsappWeb's servers.
 * Instead, methods inside {@link WhatsappAPI} should be used.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(builderClassName = "newHighlyStructuredMessage", buildMethodName = "create")
@Accessors(fluent = true)
public final class HighlyStructuredMessage implements Message {
  /**
   * Hydrated message
   */
  @JsonProperty(value = "9")
  private TemplateMessage hydratedHsm;

  /**
   * DeterministicLc
   */
  @JsonProperty(value = "8")
  private String deterministicLc;

  /**
   * DeterministicLg
   */
  @JsonProperty(value = "7")
  private String deterministicLg;

  /**
   * Localizable Params
   */
  @JsonProperty(value = "6")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<HSMLocalizableParameter> localizableParams;

  /**
   * FallbackLc
   */
  @JsonProperty(value = "5")
  private String fallbackLc;

  /**
   * FallbackLg
   */
  @JsonProperty(value = "4")
  private String fallbackLg;

  /**
   * Params
   */
  @JsonProperty(value = "3")
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<String> params;

  /**
   * Element Name
   */
  @JsonProperty(value = "2")
  private String elementName;

  /**
   * Namespace
   */
  @JsonProperty(value = "1")
  private String namespace;
}
