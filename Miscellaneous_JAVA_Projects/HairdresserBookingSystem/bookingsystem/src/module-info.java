module bookingsystem {
    exports scheduling; // means any classes in the scheduling package is now available to use by other modules
                        // Note, I don't want my customer to find the <Hairdresser> class in Module<employee>. That's why didnt export it.


}