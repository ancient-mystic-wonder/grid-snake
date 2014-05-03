game near completion

sounds - ok for now
instructions page - more in depth, better layout
score dialog - better graphics
photoshop stuff - bigger textures for better scaling
better point system, ui points
timer
asset manager
optimization (spritecache, libgdx array, etc)

http://www.joshjordan.co.uk/blog/dissertation-libgdx-android-optimisation/

http://www.java-gaming.org/index.php?topic=30592.0



SpriteBatch.totalRenderCalls = 0;

// ... render entire scene here ... //

int calls = SpriteBatch.totalRenderCalls;

//Log or render to screen
System.out.print(calls);