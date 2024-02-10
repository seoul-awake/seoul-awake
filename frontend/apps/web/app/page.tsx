import { Map, MapOverlay } from '@/components/client';

const locations = [
  { lat: 37.526072, lng: 126.864301 }, // Mok-dong station
  { lat: 37.6438741, lng: 126.6690268 }, // Janggi station
];

export default function Home() {
  return (
    <>
      <Map />
      {locations.map((position) => (
        <MapOverlay key={position.lat} position={position}>
          <div
            style={{
              backgroundColor: 'white',
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
