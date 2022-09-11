module customer {
    // In the module<bookingsystem>, we have exposed package<scheduling>
    // now, here we have to explicitly state customer to use the package<scheduling> and its associated classes
    requires bookingsystem; // customer cant access the Hairdresser class even its in the <bookingsystem> module. Because, only package<scheduling> has been exposed


}