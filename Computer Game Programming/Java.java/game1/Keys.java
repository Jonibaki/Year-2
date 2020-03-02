package game1;

import Utilities.SoundManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keys extends KeyAdapter implements Controller  {
  Action action;
  public Keys() {
    action = new Action();
  }

  public Action action() {
    // this is defined to comply with the standard interface
    return action;
  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    switch (key) {
      case KeyEvent.VK_UP:
        action.thrust = 1;
        SoundManager.play(SoundManager.thrust);
        break;
      case KeyEvent.VK_LEFT:
        action.turn = -1;
          SoundManager.play(SoundManager.thrust);
        break;
      case KeyEvent.VK_RIGHT:
        action.turn = 1;
          SoundManager.play(SoundManager.thrust);
        break;
      case KeyEvent.VK_SPACE:
        action.shoot = true;
        break;
      case KeyEvent.VK_ESCAPE:
        System.exit(0);
    }
  }

  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    switch (key) {
      case KeyEvent.VK_UP:
        action.thrust = 0;
        break;
      case KeyEvent.VK_LEFT:
        action.turn = 0;
        break;
        case KeyEvent.VK_RIGHT:
            action.turn = 0;
            break;
      case KeyEvent.VK_SPACE:
        action.shoot = false;
        break;
    }
  }
}
