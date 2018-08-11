public class Tower1Shoot implements TowerAttribute<Tower1> {

    private FrameCounter frameCounter = new FrameCounter(30);

    @Override
    public void run(Tower1 tower) {
        if (this.frameCounter.run()) {
            BulletTower1 bulletTower1 = new BulletTower1();
            bulletTower1.position.set(tower.position);
            // giờ em không biết đoạn dưới nên tạo GameObject không
//            bulletTower1.velocity.set(
//                    tower.position.subtract()
//            );
        }
    }
}
