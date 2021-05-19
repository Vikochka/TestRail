package modals;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestSuite {
    String name;
    String description;
    @SerializedName("project_id")
    int project_id;
}