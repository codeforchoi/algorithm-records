package etc;

public class Q5339 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("     /~\\\n")
                .append("    ( oo|\n")
                .append("    _\\=/_\n")
                .append("   /  _  \\\n")
                .append("  //|/.\\|\\\\\n")
                .append(" ||  \\ /  ||\n")
                .append("============\n")
                .append("|          |\n".repeat(3));
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
