package net.gali.apm.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShinningItem extends Item {

    private final List<Component> toolTipText;

    /*
        Item con brillo , titulo en morado  y de 0 a N lineas de descripcion
     */
    public ShinningItem(Properties properties , String ... toolTipLines){
        super(properties);
        this.toolTipText = new ArrayList<>();
        for(String line : toolTipLines){
            this.toolTipText.add(Component.literal(line).withStyle(ChatFormatting.YELLOW));
        }
    }

    @Override
    public boolean isFoil(ItemStack stack){
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack , @Nullable Level level , List<Component> tooltip , TooltipFlag flag){
        tooltip.addAll(toolTipText);
    }
}
