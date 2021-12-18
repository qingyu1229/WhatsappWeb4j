package it.auties.whatsapp.protobuf.message.standard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.protobuf.message.model.ContextualMessage;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.Arrays;

/**
 * A model class that represents a WhatsappMessage sent by a contact and that holds text inside.
 * This class is only a model, this means that changing its values will have no real effect on WhatsappWeb's servers.
 * Instead, methods inside {@link Whatsapp} should be used.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(builderMethodName = "newTextMessage", buildMethodName = "create")
@Accessors(fluent = true)
public final class TextMessage extends ContextualMessage {
  /**
   * The text that this message wraps
   */
  @JsonProperty(value = "1")
  private String text;

  /**
   * The substring of this text message that links to {@link TextMessage#canonicalUrl}, if available
   */
  @JsonProperty(value = "2")
  private String matchedText;

  /**
   * The canonical url of the link that this text message wraps, if available
   */
  @JsonProperty(value = "4")
  private String canonicalUrl;

  /**
   * The description of the link that this text message wraps, if available
   */
  @JsonProperty(value = "5")
  private String description;

  /**
   * The title of the link that this text message wraps, if available
   */
  @JsonProperty(value = "6")
  private String title;

  /**
   * The color of this text message encoded as ARGB
   */
  @JsonProperty(value = "7")
  private int textArgb;

  /**
   * The background color of this text message encoded as ARGB
   */
  @JsonProperty(value = "8")
  private int backgroundArgb;

  /**
   * The type of font used for the text message.
   */
  @JsonProperty(value = "9")
  private TextMessageFontType font;

  /**
   * The type of preview that this text message provides.
   * If said message contains a link, this value will probably be {@link TextMessagePreviewType#VIDEO}.
   * Not all links, though, produce a preview.
   */
  @JsonProperty(value = "10")
  private TextMessagePreviewType previewType;

  /**
   * The thumbnail for this text message encoded as jpeg in an array of bytes
   */
  @JsonProperty(value = "16")
  private byte[] thumbnail;

  /**
   * Determines whether the preview can be played inline
   */
  @JsonProperty(value = "18")
  private boolean doNotPlayInline;

  /**
   * Constructs a TextMessage from a text
   *
   * @param text the text to wrap
   */
  public TextMessage(String text){
    this.text = text;
  }

  /**
   * The constants of this enumerated type describe the various types of fonts that a {@link TextMessage} supports.
   * Not all clients currently display all fonts correctly.
   */
  @AllArgsConstructor
  @Accessors(fluent = true)
  public enum TextMessageFontType {
    /**
     * Sans Serif
     */
    SANS_SERIF(0),

    /**
     * Serif
     */
    SERIF(1),

    /**
     * Norican Regular
     */
    NORICAN_REGULAR(2),

    /**
     * Brydan Write
     */
    BRYNDAN_WRITE(3),

    /**
     * Bebasnue Regular
     */
    BEBASNEUE_REGULAR(4),

    /**
     * Oswald Heavy
     */
    OSWALD_HEAVY(5);

    private final @Getter int index;

    @JsonCreator
    public static TextMessageFontType forIndex(int index) {
      return Arrays.stream(values())
          .filter(entry -> entry.index() == index)
          .findFirst()
          .orElse(null);
    }
  }

  /**
   * The constants of this enumerated type describe the various types of previuew that a {@link TextMessage} can provide.
   */
  @AllArgsConstructor
  @Accessors(fluent = true)
  public enum TextMessagePreviewType {
    /**
     * No preview
     */
    NONE(0),

    /**
     * Video preview
     */
    VIDEO(1);

    private final @Getter int index;

    @JsonCreator
    public static TextMessagePreviewType forIndex(int index) {
      return Arrays.stream(values())
          .filter(entry -> entry.index() == index)
          .findFirst()
          .orElse(null);
    }
  }
}
