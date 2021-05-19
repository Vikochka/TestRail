package modals;

import com.google.gson.annotations.SerializedName;

public class Section {
    @SerializedName("suite_id")
    String suite_id;
    String name;
    @SerializedName("parent_id")
    String parent_id;
}
