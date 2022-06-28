package gameEnjin

import gameEnjin.core.GameObject

package object utils {
  def forAllGameObjectsAndChildren(gameObjects: List[GameObject], f: GameObject => Unit): Unit =
    gameObjects.foreach { o =>
      f(o)
      forAllGameObjectsAndChildren(o.children, f)
    }
}
