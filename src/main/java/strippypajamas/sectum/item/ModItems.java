package strippypajamas.sectum.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import strippypajamas.sectum.Sectum;

public class ModItems {
    public static Item register(String id, Item item) {
        // Create the identifier for the item.
        Identifier itemID = new Identifier(Sectum.MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    public static final Item soulBridge = register("soulbridge", new Item(new FabricItemSettings()));

    public static void initalize(){
        Sectum.LOGGER.info("Hallo World");

        Registry.register(Registries.ITEM_GROUP, SECTUM_ITEM_GROUP_KEY, SECTUM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(SECTUM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.soulBridge);
        });

    }

    public static final RegistryKey<ItemGroup> SECTUM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(Sectum.MOD_ID, "item_group"));
    public static final ItemGroup SECTUM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.soulBridge))
            .displayName(Text.of("Sectum Items"))
            .build();
}
