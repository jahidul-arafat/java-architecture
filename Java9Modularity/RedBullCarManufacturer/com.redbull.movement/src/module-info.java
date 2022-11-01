module com.redbull.movement {
    exports com.redbull.movement.api; // axel will requires it
    exports com.redbull.movement.rubberpart to com.redbull.axle, com.redbull.chassis; // Special Case; Qualified Exports used for friend-like contexts
}