package evg.megatron.decorator;

public class WitcherDialog implements Dialog {
    private String name;

    public WitcherDialog() {
        name = "Geralt";
    }

    @Override
    public String dialogWithStregobor() {
        return "Зло - это зло, Стрегобор.";
    }
}
