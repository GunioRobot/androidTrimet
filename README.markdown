#androidTrimet is a Trimet client library for the Android operating system.

##Purpose:
The main thing that this library buys you is not having to parse the XML yourself and not having to figure out how to properly use AsyncTasks (or
Threads) to perform non-blocking network lookups.


##Current State:
This is actively being worked on library. Presently, all of the functionality that is present in [Trimet's web services](http://developer.trimet.org/ws_docs/) is fully supported, except planning a trip (which will be coming soon).

Other than Trip Planning, the piece that most needs improvement is documentation. Here's a hint: You'll want to start with an instance of the TrimetClient class and then call the methods it exposes.


##Notes:
This currently requires Android 1.5+. I see no reason it couldn't be back-ported to 1.0+ if AsyncTask was replaced with UserTask (from [the Shelves source](http://code.google.com/p/shelves/source/browse/trunk/Shelves/src/org/curiouscreature/android/shelves/util/UserTask.java)), but I elected to standardize on 1.5 as something like 99.8% of phones are running at least that version.

Finally, please read the [LICENSE](http://github.com/fixedd/androidTrimet/raw/master/LICENSE) file if you would like to use this in your software and keep in mind that this is still undergoing heavy development, so things may change drastically. This document **will** be updated when it is considered "stable".

---

Jeremy Logan
Killer Robots LLC
20 January 2010

