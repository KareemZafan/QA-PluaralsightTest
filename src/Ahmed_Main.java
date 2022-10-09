import java.util.ArrayList;
import java.util.List;

public class Ahmed_Main {

    public static void main(String[] args) {
        List<String> webHostingRepos = new ArrayList<>();
        webHostingRepos.addAll(List.of("giLab","gitHub","bitBucket"));

        for (String tool:webHostingRepos) {
            System.out.println(tool);
        }
    }
}
