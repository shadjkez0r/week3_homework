package evg.megatron.decorator;

public class NotHolyHermitDialogDecorator implements Dialog {
    private final Dialog dialog;

    public NotHolyHermitDialogDecorator(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public String dialogWithStregobor() {
        return dialog.dialogWithStregobor()
                + "\n" + "Я не святой отшельник, не только одно добро творил в жизни.";
    }
}
