package toetsGame

import gameEnjin.core.{GameObject, GameObjectComponent}
import gameEnjin.geometry.{PolygonShape, Vector2}
import gameEnjin.physics.Rigidbody
import gameEnjin.rendering.{Color, PolygonVisualData}

class Karretjie(name: String) extends GameObject(name) {
  var speed: Float = 20
  var finishLine: Float = 300
  var gameManager: GameManager = null
  var stopped = false

  // Kar script:
  addComponent(new GameObjectComponent {

    override def update(delta: Float): Unit =
      if (stopped) return
      position += Vector2.right * speed * delta
      if (position.x > finishLine)
        gameManager.win(gameObject.asInstanceOf[Karretjie])
  })

  // Kar body:
  addComponent(new PolygonVisualData(PolygonShape(List(Vector2(10, 5), Vector2(10, -5), Vector2(-10, -5), Vector2(-10, 5))), Color(.2, .3, .7)))

  // Kar vensters:
  addComponent(new PolygonVisualData(PolygonShape(List(Vector2(-2, -4), Vector2(-2, 4), Vector2(2, 4), Vector2(2, -4))), Color(.50, .50, 0)) {
    offset = Vector2(3, 0)
  })
  addComponent(new PolygonVisualData(PolygonShape(List(Vector2(-1, -4), Vector2(-1, 4), Vector2(1, 4), Vector2(1, -4))), Color(.50, .50, 0) * .9) {
    offset = Vector2(-7, 0)
  })
}
