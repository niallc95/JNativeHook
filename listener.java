import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
/**
 * @author N Curran
 *KeyLogger Listener
 */
public class listener implements NativeKeyListener {

    /* Key Pressed */
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        /* close program when esc is pressed */
        if (e.getKeyCode() == NativeKeyEvent.VK_ESCAPE) {
            GlobalScreen.unregisterNativeHook();
        }
    }

    /* When Key is Released */
    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    /*No output */
    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    public static void main(String[] args) {
        try {
            /* Register jNativeHook */
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            /* error */
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        /* Construct the object and initialze native hook. */
        GlobalScreen.getInstance().addNativeKeyListener(new jNativeHookExample());
    }
