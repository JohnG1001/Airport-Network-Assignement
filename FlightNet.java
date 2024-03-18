package airlines;
import java.util.HashSet;

public class FlightNet extends HashSet<Airport>
{
	//Returns true if the FlightNet doesn't contain an airport with the specified name
	public boolean nameIsAvailable(String name)
	{
		for(Airport a : this)
		{
			if(a.getName().equals(name))
			{
				return false;
			}
		}
		
		return true;
	}
	
	//Connects a1 to a2 and a2 to a1
	public void connect(Airport a1, Airport a2)
	{
		a1.connectTo(a2);
		a2.connectTo(a1);
	}
	
	//Disconnects a1 from a2 and a2 from a1	
	public void disconnect(Airport a1, Airport a2)
	{	
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}
	
	//Removes designated Airport from FlightNet and disconnects from any other Airports
	public void removeAndDisconnect(Airport removeMe)
	{
		for(Airport a : this)
		{
			if(a.isConnectedTo(removeMe))
			{
				a.disconnectFrom(removeMe);
			}
		}
		this.remove(removeMe);
	}
	
	//Checks all airports in the FlightNet
	//Returns the first airport whos (x,y) is within max distance of the args
	//Returns null if no airport is within maximumDistance
	public Airport getAirportNearXY(int x, int y, int maximumDistance)
	{
		for(Airport a : this)
		{
			double distanceTraveled = Math.hypot(x - a.getX(), y - a.getY());
			if(distanceTraveled <= maximumDistance)
			{
				return a;
			}
		}
		
		return null;
		
	}
}
