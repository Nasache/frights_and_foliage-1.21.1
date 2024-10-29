package net.nathan.frights_and_foliage.blocks.entity;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;

public class ModCampfireBlockEntityRenderer implements BlockEntityRenderer<ModCampfireBlockEntity> {
    private static final float SCALE = 0.375F;
    private final ItemRenderer itemRenderer;

    public ModCampfireBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(ModCampfireBlockEntity campfireBlockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Direction direction = campfireBlockEntity.getCachedState().get(CampfireBlock.FACING);
        DefaultedList<ItemStack> items = campfireBlockEntity.getItemsBeingCooked();
        int posHash = (int) campfireBlockEntity.getPos().asLong();

        for (int i = 0; i < items.size(); i++) {
            ItemStack itemStack = items.get(i);
            if (!itemStack.isEmpty()) {
                matrices.push();
                matrices.translate(0.5F, 0.44921875F, 0.5F); // Center the item on the campfire
                Direction itemDirection = Direction.fromHorizontal((i + direction.getHorizontal()) % 4);
                float rotation = -itemDirection.asRotation();
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
                matrices.translate(-0.3125F, -0.3125F, 0.0F);
                matrices.scale(SCALE, SCALE, SCALE);

                this.itemRenderer.renderItem(itemStack, ModelTransformationMode.FIXED, light, overlay, matrices, vertexConsumers, campfireBlockEntity.getWorld(), posHash + i);
                matrices.pop();
            }
        }
    }
}