LU Announcements - Train Tunnel Sounds (Fabric 1.20.1)
======================================================
Adds two blocks (creative inventory > Functional Blocks):
  Train Tunnel Sound         /give @s luannouncements:train_tunnel_sound
  Spooky Train Tunnel Sound  /give @s luannouncements:train_tunnel_sound_spooky
Once placed, each one plays its sound on a loop forever, the same way the
"See it Say it Sorted" block does in the MTR London Underground Addon.

Build it online for free: upload everything in this folder to a GitHub
repository (create .github/workflows/build.yml by hand), open the Actions tab,
wait for the green tick and download the artifact. Or run:  gradle build

Tweaks (src/main/java/net/luannouncements/TunnelSoundMod.java):
    The two numbers on each block are  loopTicks (sound length in seconds x 20)
    and volume (1.0 is about 16 blocks range, 4.0 about 64).

Credit: the block texture is copied from the MTR London Underground Addon
(MIT licence, t1NbLu3).
