module com.example.renderer {
    exports support to com.example.client; // module<client> may not have dependency of module<data>
                                            // but as we define it transitive, means module<client> accessing module<renderer> still can access module<data>
    requires transitive com.example.data;  // exports
                                // package<message> --> all and
                                // package<type> --> rendered
}