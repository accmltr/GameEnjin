package gameEnjin.core

trait GameObjectComponent {
  private var _gameObject: GameObject = _
  private var _started: Boolean = false

  /**
   * Used by the game engine to call update()
   *
   * Note: methods starting with _special_access are used by the game engine, and are not intended for use in game development.
   */
  def _special_access_update(delta: Float): Unit =
    if (!_started)
      start()
      _started = true
    else update(delta)

  /**
   * Called once when a component becomes part of the game loop for the first time.
   */
  def start(): Unit = {}

  /**
   * Called once per frame. Mainly used for custom code that updates your game objects.
   *
   * @param delta The time from the last frame's beginning to this frame's beginning.
   */
  def update(delta: Float): Unit = {}

  /**
   * The GameObject this script, or GameObjectComponent, belongs to. (This component's game object)
   */
  def gameObject: GameObject = _gameObject

  def gameObject_=(o: GameObject): Unit =
    if (_gameObject == null) _gameObject = o else throw Exception("Trying to set gameObject property on a GO component that already belongs to a gameObject.")
}
