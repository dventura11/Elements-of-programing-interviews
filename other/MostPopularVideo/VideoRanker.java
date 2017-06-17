import java.io.*;
import java.util.*;

public class VideoRanker {

  /*
   * This class save tha values of each position of the videos views
   */
  private class ViewsNode implements Comparable<ViewsNode> {
    //Number of views, this is the identifies of the node, for that reasos I return that value in hashCode method
    //the nodes will be saved in an Treeset and views are integer in order to call its compareTo method
    Integer views;
    //This ser contains the videos that have the number of views in the node
    //the implementation selected is a HashSet to acces to the information in O(1)
    //I used a set instead of a counter because this information is necessary to return the result of getTopVideos method
    Set<String> videos;
    //This variable will save the current position in the rank I am saving it because getRanking method will be called a lot
    //and I want to maintain this value updated and not calculated each call and waste more processing time.
    int position;

    private ViewsNode(Integer views) {
      this.views = views;
      this.videos = new HashSet<String>();
    }

    @Override
    public int hashCode() {
      return this.views;
    }

    @Override
    public String toString() {
      return String.format("views: %d\tquantity: %d\tposition: %d\tvideos:%s", views, videos.size(), position, videos.toString());
    }

    public int compareTo(ViewsNode node) {
      //I multiply the result to -1 because I want a descending order in the Treeset
      return -1*this.views.compareTo(node.views);
    }
  }

  //This variable is used to save the current views of each video, the implementation is a HashMap
  //then I can access to the information in O(1), is important because getRanking is called frecuentely
  private Map<String, Integer> viewsMap;
  //This treset is used to save the nodes information where the node with more views will be on the top of the set
  //the implementation is a treeset, that let me insert, delete and search nodes in O(log(n))
  private TreeSet<ViewsNode> topSet;

  public VideoRanker() {
    viewsMap = new HashMap<String, Integer>();
    topSet = new TreeSet<ViewsNode>();
  }

  /**
   * Called when a single quantity of the given product has been sold.
   * This should update internal product rankings as necessary.
   *
   * @param videoId the unique identifier for the video
   */
  public void videoViewed(String videoId) {
    if ( viewsMap.containsKey(videoId) ) {
      //When the video does not exist in the current map
      //I get the node from the topSet
      ViewsNode node = new ViewsNode( viewsMap.get(videoId) );
      node = topSet.ceiling(node);
      //I remove this video from the set of videos with the same number of views
      node.videos.remove(videoId);
      //The rest of the videos will be in the next position
      node.position++;
      if ( node.videos.isEmpty() ) {
        //If there are not more videos then I remove the node
        topSet.remove(node);
      } else {
        //if there are more then update the node
        topSet.add(node);
      }
      //Update the current views in the map
      viewsMap.put(videoId, viewsMap.get(videoId) + 1);
    } else {
      //When the video does not exist in the current map then I added it whit only one view
      viewsMap.put(videoId, 1);
    }
    //I get the node with the current views of the video, if not exist I create a new one
    ViewsNode node = new ViewsNode( viewsMap.get(videoId) );
    node = topSet.contains(node) ?  topSet.ceiling(node) : node;
    //I add the video id to the set of videos whit this number of views
    node.videos.add(videoId);
    ViewsNode lowerNode = topSet.lower(node);
    if ( lowerNode != null ) {
      node.position = lowerNode.position + lowerNode.videos.size();
    } else {
      node.position = 1;
    }
    topSet.add(node);
  }

  /**
   * Returns the relative ranking of the product on the most popular video list.
   * @return the ranking of the video.
   */
  public int getRanking(String videoId) {
    if ( ! viewsMap.containsKey(videoId) ) {
      return -1;
    }
    ViewsNode node = new ViewsNode( viewsMap.get(videoId) );
    node = topSet.ceiling(node);
    return node.position;
  }

  /**
   * Returns the top ten most popular videos in an ordered list.
   * @return a list of video ids
   */
  public List<String> getTopVideos() {
    List<String> result = new ArrayList<String>();
    int i = 0;
    for ( ViewsNode node : topSet) {
      for (String video : node.videos) {
        if (i == 10) {
          return result;
        }
        result.add(video);
        i++;
      }
    }
    return result;
  }

}
