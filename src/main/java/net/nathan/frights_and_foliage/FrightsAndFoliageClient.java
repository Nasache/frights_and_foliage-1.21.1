package net.nathan.frights_and_foliage;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.blocks.entity.ModBlockEntities;
import net.nathan.frights_and_foliage.blocks.entity.ModCampfireBlockEntityRenderer;
import net.nathan.frights_and_foliage.entity.ModBoats;
import net.nathan.frights_and_foliage.entity.ModEntities;
import net.nathan.frights_and_foliage.entity.client.*;
import net.nathan.frights_and_foliage.particle.ModParticles;
import net.nathan.frights_and_foliage.particle.OrangeAseriaParticles;
import net.nathan.frights_and_foliage.particle.RedAseriaParticles;
import net.nathan.frights_and_foliage.particle.YellowAseriaParticles;
import net.nathan.frights_and_foliage.util.ModWoodTypes;

public class FrightsAndFoliageClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_ASERIA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_RED_ASERIA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_ASERIA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ORANGE_ASERIA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_ASERIA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_YELLOW_ASERIA_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FALLEN_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_ASERIA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_ASERIA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_ASERIA_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASERIA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASERIA_TRAPDOOR, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);

        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.ASERIA, TexturedRenderLayers.getSignTextureId(ModWoodTypes.ASERIA));

        TerraformBoatClientHelper.registerModelLayers(ModBoats.ASERIA_BOAT_ID, false);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MARNOR_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_MARNOR_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MARNOR_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INFESTED_MARNOR_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MARNOR_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MARNOR_VINES_PLANT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MARNOR_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MARNOR_TRAPDOOR, RenderLayer.getCutout());

        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.MARNOR, TexturedRenderLayers.getSignTextureId(ModWoodTypes.MARNOR));

        TerraformBoatClientHelper.registerModelLayers(ModBoats.MARNOR_BOAT_ID, false);


        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_ASERIA_PARTICLE, RedAseriaParticles.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ORANGE_ASERIA_PARTICLE, OrangeAseriaParticles.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_ASERIA_PARTICLE, YellowAseriaParticles.Factory::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.SPOOKY_FIRE_FLAME, FlameParticle.Factory::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRIMSON_PUMPKIN_STEM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ATTACHED_CRIMSON_PUMPKIN_STEM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WARPED_PUMPKIN_STEM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ATTACHED_WARPED_PUMPKIN_STEM, RenderLayer.getCutout());


        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NOX_BERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAFFROOT_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GAIZE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_GAIZE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARKROSE_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMBERCUP_BUSH, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROTBUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ROTBUD, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPOOKY_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WALL_SPOOKY_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPOOKY_CAMPFIRE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TWINFIRE_BLOOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_TWINFIRE_BLOOM, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.STALK, StalkModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.STALK, StalkRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.LEPHID, LephidModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.LEPHID, LephidRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.FUMKIN, FumkinModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FUMKIN, FumkinRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.VIRE, VireModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.VIRE, VireRenderer::new);

        EntityRendererRegistry.register(ModEntities.VIRE_FEATHER_ARROW, VireArrowEntityRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.MOD_CAMPFIRE_BLOCK_ENTITY, ModCampfireBlockEntityRenderer::new);
    }
}
