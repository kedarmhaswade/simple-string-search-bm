simple-string-search-bm
=======================

A caliper benchmark for string replacement code ...

### Instructions

1. [Check out/clone](https://code.google.com/p/caliper/source/checkout) and build caliper, this version may be there in some maven repo, but it's just easier to build it.
2. mvn clean install
2. Browse to [http://microbenchmarks.appspot.com/](http://microbenchmarks.appspot.com/) and log in. You should get an appspot API key. Follow the instructions to append it to ~/.caliper/config.properties.
3. mvn exec:java
