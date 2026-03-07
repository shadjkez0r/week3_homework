package evg.megatron.decorator;

public class PreferNotToChooseDialogDecorator implements Dialog {
    private final Dialog dialog;

    public PreferNotToChooseDialogDecorator(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public String dialogWithStregobor() {
        return dialog.dialogWithStregobor()
                + "\n" + "Но если приходится выбирать между одним злом и другим," +
                " я предпочитаю не выбирать вообще.";
    }
}
