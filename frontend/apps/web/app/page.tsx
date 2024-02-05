import Map from '../components/client/Map/Map';
import MapOverlay from '../components/client/Map/MapOverlay';

const locations = [
  { lat: 37.526072, lng: 126.864301 }, // 목동
  { lat: 37.6438741, lng: 126.6690268 }, // 장기
];

export default function Home() {
  return (
    <>
      <Map />
      {locations.map((position) => (
        <MapOverlay key={position.lat} position={position}>
          <div
            style={{
              backgroundColor: 'black',
              padding: '10px',
              borderRadius: '8px',
            }}
          >
            tooooo1
          </div>
        </MapOverlay>
      ))}
    </>
  );
}
