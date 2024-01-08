# StutterFix

<p>StutterFix is a mod that allows you to configure the main threads of the game, allowing you to control stuttering. By default, the mod already comes with an approximate configuration to reduce stuttering.</p>

<p>The new version 0.1.8 allows you to configure threads, I added a new option in the menu.</p>

<h1>Option Menu </h1>

<p>There are five options available for configuration, with <strong>N</strong> being the number of threads your processor supports:</p>

<ul>
<li><p><strong> Worker threads count</strong><br>Vanilla default N - 1, StutterFix default N - 5, is the number of threads running to perform tasks like generating chunks. The smaller the value, the less CPU overhead, reducing stuttering, and the slower the chunk generation speed.</p></li>
<li><p><strong> Priority cutoff point</strong><br>Indicates the cutoff point for the priority of worker threads. The higher the value, the higher the first part of the threads will be with normal priority and the lower the last part will be with minimum priority. The value must be less than the number of worker threads to have the cutoff point, otherwise all threads will have normal priority. Threads with minimum priority help reduce stuttering.</p></li>
<li><p><strong> Render thread priority</strong><br> The rendering thread is where the client runs, such as the player, sound, inputs, and rendering.</p></li>
<li><p><strong> Server thread priority</strong><br> In singleplayer mode, the game starts the integrated server that runs the entire world, such as ticks, entities and initializing the generation of chunks (which will be executed in the worker threads). This option only appears when playing in a world in singleplayer mode.</p></li>
<li><p><strong> Remove Yield()</strong><br> The rendering thread has a call made in each loop, called yield(), with the function of informing the “scheduler” that the current thread is willing to abandon the current use of the processor to other threads. Removing yield() can make fps more stable.</p></li>
</ul>

<p>The <strong>Worker Threads Count</strong>, <strong>Priority cutoff point</strong> setting has little effect in multiplayer because the world is generated by the server and therefore there are no stuttering issues for the client caused by the generation in the world.</p>


<h1>Other mods I recommend</h1>

<p> I recommend using this mod with the Sodium mod and Concurrent Chunk Management Engine (C2ME).</p>


<h1>Changelog</h1>

<p>In versions 0.1.5 and earlier, all these worker threads have minimum priority, due to the low responsiveness in chunk generation I decided to release 0.1.6 with the worker threads in normal priority. </p>

<p>In version 0.1.7 I had the idea of leaving the first half of the worker threads with normal priority and the last half with minimum priority to better reduce stuttering and better responsiveness when generating chunks. </p>

<p>In version 0.1.8, I created the option in the menu to configure threads and also removed the removal of Thread.yield() as it was conflicting with other mods like VulkanMod.</p>

<p>In version 0.1.9, the remove yield() option was added, if you use VulcanMod, this option will not appear in the menu. The tooltip has been improved.</p>

<p>In version 0.2.0, changes were made to the gui, to resolve compatibility issues with some mods, such as <strong>bedrockify</strong>.</p>


<h1> Warnings</h1>
<p>The mod does not affect the stuttering problem that occurs due to the garbage collector, I reduced the problem by using -XX:+UseShenandoahGC and allocating more memory in jvm arguments, do a search for jvm arguments for minecraft to get more information.</p>

<strong>If you encounter any issues, please report the issue on <a href="https://github.com/wisecase2/StutterFix/issues">Github</a>.</strong>

Demonstration (old):
https://youtu.be/AaZ1jAqitQk
