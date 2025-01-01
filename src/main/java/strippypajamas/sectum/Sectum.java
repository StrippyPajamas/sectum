package strippypajamas.sectum;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import strippypajamas.sectum.item.ModItems;

public class Sectum implements ModInitializer {
	public static final String MOD_ID = "sectumid";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		ModItems.initalize();

	}

}