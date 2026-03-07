package evg.megatron.decorator;

public class LessMoreMiddleDialogDecorator implements Dialog {
    private final Dialog dialog;

    public LessMoreMiddleDialogDecorator(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public String dialogWithStregobor() {
        return dialog.dialogWithStregobor()
                + "\n" + "Меньшее, большее, среднее - все едино," +
                " пропорции условны, а границы размыты.";
    }
}
