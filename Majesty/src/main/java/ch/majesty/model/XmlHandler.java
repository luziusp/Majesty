package ch.majesty.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.collections.ObservableList;


public class XmlHandler {

	// Static = klassengebunden, und dann muss nicht NEW xmlhandler geschrieben
	// werden!
	public static void marshall(ObservableList<Player> PlayerData, File datei) {

		JAXBContext context;
		BufferedWriter writer;

		try {
			writer = new BufferedWriter(new FileWriter(datei));

			// Mitteilen des obersten XML-Elements
			context = JAXBContext.newInstance(Players.class);

			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(new Players(PlayerData), writer);

			writer.close();

		} catch (Exception e) {
			System.err.println("Upsss, irgendetwas ist beim Schreiben des XML-Files schief gelaufen.");
		}
	}

	public static ObservableList<Player> unmarshall(File datei) {

		Players PlayerData = new Players();

		JAXBContext context;

		try {
			context = JAXBContext.newInstance(Players.class);
			Unmarshaller um = context.createUnmarshaller();
			PlayerData = (Players) um.unmarshal(datei); // Cast, da Players
															// kein objekt ist.

		} catch (Exception e) {
			System.err.println("Upsss");
		}

		return PlayerData.getPlayersData();
	}

}
