package clientserver;

import java.awt.Color;

import ch.majesty.model.Player;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ChatMessage {
	Player player;
	String Message;
	Color color;
}
