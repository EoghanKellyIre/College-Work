
public class Dijkstra
{
	//public double[] distTo;
	//public DirectedEdge[] edgeTo;
	//public IndexMinPQ<Double> priorityQueue;
	
	public Dijkstra(StoringGraph graph, int source)
	{
		//distTo = new double[graph.getIntersections()];
		//edgeTo = new DirectedEdge[graph.getIntersections()];
		
		 public void dijkstra_GetMinDistances(int source)
		 {
			 boolean[] SPT = new boolean[Graph.Edge];
			 //distance used to store the distance of vertex from a source
			 int [] distance = new int[vertices];

			 //Initialize all the distance to infinity
			 for (int i = 0; i <vertices ; i++) {
			 distance[i] = Integer.MAX_VALUE;
			 }
			 //Initialize priority queue
			 //override the comparator to do the sorting based keys
			 PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
			 @Override
			 public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
			 //sort using distance values
			 int key1 = p1.getKey();
			 int key2 = p2.getKey();
			 return key1�key2;
			 }
			 });
			 //create the pair for for the first index, 0 distance 0 index
			 distance[0] = 0;
			 Pair<Integer, Integer> p0 = new Pair<>(distance[0],0);
			 //add it to pq
			 pq.offer(p0);

			 //while priority queue is not empty
			 while(!pq.isEmpty()){
			 //extract the min
			 Pair<Integer, Integer> extractedPair = pq.poll();

			 //extracted vertex
			 int extractedVertex = extractedPair.getValue();
			 if(SPT[extractedVertex]==false) {
			 SPT[extractedVertex] = true;

			 //iterate through all the adjacent vertices and update the keys
			 LinkedList<Edge> list = adjacencylist[extractedVertex];
			 for (int i = 0; i < list.size(); i++) {
			 Edge edge = list.get(i);
			 int destination = edge.destination;
			 //only if edge destination is not present in mst
			 if (SPT[destination] == false) {
			 ///check if distance needs an update or not
			 //means check total weight from source to vertex_V is less than
			 //the current distance value, if yes then update the distance
			 int newKey = distance[extractedVertex] + edge.weight ;
			 int currentKey = distance[destination];
			 if(currentKey>newKey){
			 Pair<Integer, Integer> p = new Pair<>(newKey, destination);
			 pq.offer(p);
			 distance[destination] = newKey;
			 }
			 }
			 }
			 }
			 }
			 //print Shortest Path Tree
			 printDijkstra(distance, sourceVertex);
			 }

	public boolean hasPathTo(int j) {
		// TODO Auto-generated method stub
		return false;
	}

	public double distTo(int j) {
		// TODO Auto-generated method stub
		return 0;
	}

}
