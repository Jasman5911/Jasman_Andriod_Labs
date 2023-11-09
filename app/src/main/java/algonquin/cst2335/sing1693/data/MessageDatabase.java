package algonquin.cst2335.sing1693.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {ChatMessage.class}, version =2)
public abstract class MessageDatabase extends RoomDatabase {
    public abstract ChatMessageDAO cmDAO();
}
