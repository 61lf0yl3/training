class Problem5 {
    public static void main(String[] args) {
    Ant adam = new Ant(5); // starts at position 5, facing left
    adam.move();
    adam.move();
    System.out.println(adam.getPosition()); // it's now at position 3
    adam.turn(); // turns in the opposite direction
    adam.move();
    adam.move();
    adam.move(); // at position 6 now
    System.out.println(adam.getPosition()); // at position 6 now
    adam.turn();
    adam.turn();
    System.out.println(adam.isFacingRight()); // returns true
}
}