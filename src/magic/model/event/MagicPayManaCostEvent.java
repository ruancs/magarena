package magic.model.event;

import magic.model.MagicGame;
import magic.model.MagicManaCost;
import magic.model.MagicPlayer;
import magic.model.MagicSource;
import magic.model.choice.MagicPayManaCostChoice;

public class MagicPayManaCostEvent extends MagicEvent {
    public MagicPayManaCostEvent(final MagicSource source, final String cost) {
        this(source, source.getController(), MagicManaCost.create(cost));
    }

    public MagicPayManaCostEvent(final MagicSource source,final MagicPlayer player,final MagicManaCost cost) {
        super(
            source,
            player,
            new MagicPayManaCostChoice(cost),
            EVENT_ACTION,
            "Pay "+cost.getText()+"$."
        );
    }
    
    private static final MagicEventAction EVENT_ACTION=new MagicEventAction() {
        @Override
        public void executeEvent(
                final MagicGame game,
                final MagicEvent event) {
            event.payManaCost(game,event.getPlayer());
        }
    };
}
