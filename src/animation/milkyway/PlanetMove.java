package animation.milkyway;

public class PlanetMove extends Thread {

    private Planet planet;
    private int sleep;
    private int t = 0;

    public PlanetMove(Planet planet, int sleep) {
        this.planet = planet;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        for(t = 0; t < 360; ) {
            try {
                Thread.sleep(sleep);
                planet.jl.setBounds((int) (planet.getRadius()*Math.cos(t*Math.PI/180) + planet.getDx()),
                        (int) (planet.getRadius()*Math.sin(t*Math.PI/180) + planet.getDy()),
                        planet.getImage().getWidth(), planet.getImage().getHeight());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t = t == 359 ? 0 : t+1;
        }
    }
}
