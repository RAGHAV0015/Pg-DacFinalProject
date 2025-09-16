import axios from 'axios'
import { useEffect, useState } from 'react'
import swal from 'sweetalert2'
import { apiUrls, baseUrl } from '../lib/constants'

export default function AddPark() {
  const [data, setData] = useState([])
  const [parkName, setparkName] = useState()
  const [ownerName,setownerName]=useState()
  const [workerName,setworkerName]=useState()
  const [facility,setfacility]=useState()
  const [description,setdescription]=useState()
  const [year,setyear]=useState()
  const [parkid,setparkid]=useState(0)
  const [selectedPhoto, setSelectedPhoto] = useState(null)

  const handleSubmit = (e) => {
    e.preventDefault()
    if (parkName === undefined || year===undefined || description === undefined ||
      ownerName === undefined || workerName === undefined || facility === undefined) {
      swal.fire({
        title: 'Error',
        icon: 'error',
        text: 'Please fill all details',
      })
      return
    }
    const formData = new FormData()
    formData.append('photo', selectedPhoto)
    formData.append('parkName', parkName)
    formData.append('year', year)
    formData.append('ownerName', ownerName)
    formData.append('workerName', workerName)
    formData.append('facility', facility)
    formData.append('description', description)
    formData.append('parkId',parkid)
    axios
      .post(baseUrl+apiUrls.PARKS_URL, formData)
      .then((resp) => {
        console.log(resp)
        swal.fire({
          title: 'Success',
          text: 'Park Added Successfully',
        })
        setparkName('')
        setownerName('')
        setworkerName('')
        setfacility('')
        setyear('')
        setdescription('')
        setparkid(0)
        setSelectedPhoto(null)
        loadData()
      })
      .catch((err) => {
        swal.fire({
          title: 'error',
          icon: 'error',
          text: 'Cannot save park',
        })
      })
  }

  const handleEdit = (park) =>{
      setparkName(park.parkName)
      setyear(park.year)
      setownerName(park.ownerName)
      setworkerName(park.workerName)
      setfacility(park.facility)
      setdescription(park.description)
      setparkid(park.parkId)
  }

  const handleDelete = (id) => {
    axios
      .delete(baseUrl+apiUrls.PARKS_URL + id)
      .then((resp) => {
        swal.fire({
          icon: 'error',
          title: 'Deleted',
          text: 'Park Deleted  Successfully',
        })
        loadData()
      })
      .catch((err) => {
        swal.fire({
          title: 'Error',
          icon: 'error',
          text: 'Cannot delete park',
        })
      })
  }
  const handleFileInput = (e) => {
    setSelectedPhoto(e.target.files[0])
  }
  const loadData = () => {
    axios.get(baseUrl+apiUrls.PARKS_URL).then((resp) => {
      setData(resp.data)
    })
  }
  useEffect(() => {
    loadData()
  }, [])
  return (
    <>
      <div className='container mt-5'>
        <div className='row'>
          <div className='col-sm-8'>
            <h5 className='p-2'>Park List</h5>
            <table className='table table-bordered'>
              <thead>
                <th>Id</th>
                <th>Parking Name</th>
                <th>Action</th>
              </thead>
              <tbody>
                {data?.map((x) => (
                  <tr key={x?.parkId}>
                    <td>{x?.parkId}</td>
                    <td>
                      <img
                      className='float-start'
                        src={'http://localhost:8080/' + x?.poster}
                        style={{
                          width: '100px',
                          height: '120px',
                          marginRight: '10px',
                        }}
                      />
                      {x?.parkName}<br/>
                      Park owner name: {x?.ownerName}<br/>
                      Park worker name: {x?.workerName}
                    </td>
                    <td>
                      <button
                        onClick={(e) => handleDelete(x.parkId)}
                        className='btn btn-danger btn-sm'
                      >
                        Delete
                      </button>
                      <button
                        onClick={(e) => handleEdit(x)}
                        className='btn btn-primary btn-sm ms-2'
                      >
                        Edit
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
          <div className='col-sm-4'>
            <h5>Add Park</h5>
            <form>
              <div className='mb-2'>
                <label>Park Name</label>
                <input
                  type='text'
                  className='form-control form-control-sm'
                  value={parkName}
                  onChange={(e) => setparkName(e.target.value)}
                />
              </div>
              <div className='mb-2'>
                <label>Park Owner Name</label>
                <input
                  type='text'
                  className='form-control form-control-sm'
                  value={ownerName}
                  onChange={(e) => setownerName(e.target.value)}
                />
              </div>
              <div className='mb-2'>
                <label>Park worker Name</label>
                <input
                  type='text'
                  className='form-control form-control-sm'
                  value={workerName}
                  onChange={(e) => setworkerName(e.target.value)}
                />
              </div>
              <div className='mb-2'>
                <label>Parking facility</label>
                <input
                  type='text'
                  className='form-control form-control-sm'
                  value={facility}
                  onChange={(e) => setfacility(e.target.value)}
                />
              </div>
              <div className='mb-2'>
                <label>Park build year</label>
                <input
                  type='number'
                  className='form-control form-control-sm'
                  value={year}
                  onChange={(e) => setyear(e.target.value)}
                />
              </div>
              <div className='mb-2'>
                <label>Description</label>
                <textarea
                  rows={3}
                  className='form-control form-control-sm'
                  value={description}
                  onChange={(e) => setdescription(e.target.value)}
                ></textarea>
              </div>
              <div className='mb-2'>
                <label>Parking Image</label>
                <input
                  type='file'
                  onChange={handleFileInput}
                  className='form-control-file form-control'
                />
              </div>
              <button
                onClick={handleSubmit}
                className='btn btn-primary btn-sm float-end'
              >
                Save Details
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  )
}
