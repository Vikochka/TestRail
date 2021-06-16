package modals;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Run {
    @SerializedName("suite_id")
    int suite_id;
    String name;
    String description;
    int milestone_id;
    int assignedto_id;
    boolean include_all;
    String refs;
}
