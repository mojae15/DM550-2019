import java.util.ArrayList;

public class BinaryTreeCalc{

  public static void main(String[] args){
    BinaryTree<Double> dTree = new BinaryTree<Double>();
    dTree.add(1.0);
    dTree.add(2.0);
    dTree.add(3.0);
    dTree.add(4.0);
    dTree.add(5.0);

    //System.out.println(sum(dTree));

    BinaryTree<Integer> iTree = new BinaryTree<Integer>();
    iTree.add(1);
    iTree.add(2);
    iTree.add(4);
    iTree.add(6);
    iTree.add(3);

    // System.out.println(zeros(iTree));
    // System.out.println(toArrayList(iTree));
    System.out.println(selectLarger(iTree, 3));

    BinaryTree<String> sTree = new BinaryTree<String>();
    sTree.add("en");
    sTree.add("to");
    sTree.add("en");
    sTree.add("tre");
    sTree.add("en");

    // System.out.println(count(sTree, "en"));

  }
  private static double sum(BinaryTree<Double> t){
    if(t.isEmpty()){
      return 0;
    } else{
      return t.root() + sum(t.left()) + sum(t.right());
    }
    //løst itterativt ved at bruge Iteratoren
    // double sum = 0.0;
    // for(Double d: dTree){
    //   sun = sum + d;
    // }
    // return sum;
  }

  private static int zeros(BinaryTree<Integer> t){
    if(t.isEmpty()){
      return 0;
    } else{
      if(t.root() == 0){
        return 1 + zeros(t.left()) + zeros(t.right());
      } else{
        return zeros(t.left()) + zeros(t.right());
      }
    }
  }

  private static int count(BinaryTree<String> t, String s){
    if(t.isEmpty()){
      return 0;
    } else{
      if(t.root().equals(s)){
        return 1 + count(t.left(), s) + count(t.right(), s);
      } else{
        return count(t.left(), s) + count(t.right(), s);
      }
    }
  }

  private static ArrayList<Integer> toArrayList(BinaryTree<Integer> t){
    ArrayList<Integer> iArr = new ArrayList<Integer>();
    if(t.isEmpty()){
      return iArr;
    } else{
      iArr.add(t.root());
      iArr.addAll(toArrayList(t.left()));
      iArr.addAll(toArrayList(t.right()));
    }
    return iArr;
  }

  private static ArrayList<Integer> selectLarger(BinaryTree<Integer> t, int n){
    ArrayList<Integer> iArr = new ArrayList<Integer>();
    if(t.isEmpty()){
      return iArr;
    } else{
      if(t.root() > n){
        iArr.add(t.root());
      }
      iArr.addAll(selectLarger(t.left(), n));
      iArr.addAll(selectLarger(t.right(), n));

    }
    return iArr;
  }

}
